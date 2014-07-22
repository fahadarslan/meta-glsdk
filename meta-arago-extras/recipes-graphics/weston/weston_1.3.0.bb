SUMMARY = "Weston, a Wayland compositor"
DESCRIPTION = "Weston is the reference implementation of a Wayland compositor"
HOMEPAGE = "http://wayland.freedesktop.org"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=275efac2559a224527bd4fd593d38466 \
                    file://src/compositor.c;endline=23;md5=aa98a8db03480fe7d500d0b1f4b8850c"

SRC_URI = "git://anongit.freedesktop.org/wayland/weston;protocol=git \
           file://weston.png \
           file://weston.desktop \
           file://terminal.png \
           file://pattern.png \
           file://profile \
           file://0001-compositor-drm-Change-path-of-gbm.h-to-gbm-gbm.h.patch \
           file://0002-Makefile-Include-option-to-search-in-include-drm.patch \
	   file://0003-input-source-prevent-input-disable-during-repaint.patch \
	   file://0005-temp-hack-to-enable-weston-1.3.patch \
	   file://0006-weston-drm-Enable-multiple-displays.patch "
          

SRCREV = "95659c03219b057d9d703b04cf89bc0329ce947a" 

S = "${WORKDIR}/git"

PR = "r3"

inherit autotools pkgconfig useradd

DEPENDS = "xkbcommon gdk-pixbuf pixman cairo glib-2.0 jpeg mtdev libpam"
DEPENDS += "wayland libgbm omap5-sgx-ddk-um-linux pango"


EXTRA_OECONF = "--disable-android-compositor \
                 --disable-simple-egl-clients \
                 --enable-fbdev-compositor \
                --enable-setuid-install \
                --disable-tablet-shell \
                --disable-xwayland \
                --enable-simple-clients \
                --enable-clients \
                --disable-libunwind \
                --disable-rpi-compositor \
                --disable-rdp-compositor \
                --prefix=${STAGING_DIR_TARGET} \
                --with-libtool-sysroot=${STAGING_DIR_TARGET}"


PACKAGECONFIG ??= "${@base_contains('DISTRO_FEATURES', 'wayland', 'kms wayland', '', d)} \
                   ${@base_contains('DISTRO_FEATURES', 'x11', 'x11', '', d)} \
                   ${@base_contains('DISTRO_FEATURES', 'opengles2', 'gles', '', d)} \
                   ${@base_contains('DISTRO_FEATURES', 'pam', 'launch', '', d)} \
                  "
#
# Compositor choices
#
# Weston on KMS
PACKAGECONFIG[kms] = "--enable-drm-compositor,--disable-drm-compositor,drm udev libgbm mtdev"
# Weston on Wayland (nested Weston)
PACKAGECONFIG[wayland] = "--enable-wayland-compositor,--disable-wayland-compositor,libgbm"
# Weston on X11
PACKAGECONFIG[x11] = "--enable-x11-compositor,--disable-x11-compositor,virtual/libx11 libxcb libxcb libxcursor cairo"
# Headless Weston
PACKAGECONFIG[headless] = "--enable-headless-compositor,--disable-headless-compositor"
# Weston on framebuffer
PACKAGECONFIG[fbdev] = "--enable-fbdev-compositor,--disable-fbdev-compositor,udev mtdev"
# weston-launch
PACKAGECONFIG[launch] = "--enable-weston-launch,--disable-weston-launch,libpam"
# Use cairo-gl or cairo-glesv2
PACKAGECONFIG[gles] = "--with-cairo-glesv2,,virtual/libgles2"



do_install_append() {
	# Weston doesn't need the .la files to load modules, so wipe them
	rm -f ${D}/${libdir}/weston/*.la

	for feature in ${DISTRO_FEATURES}; do
		# If X11, ship a desktop file to launch it
		if [ "$feature" = "x11" ]; then
			install -d ${D}${datadir}/applications
			install ${WORKDIR}/weston.desktop ${D}${datadir}/applications

			install -d ${D}${datadir}/icons/hicolor/48x48/apps
			install ${WORKDIR}/weston.png ${D}${datadir}/icons/hicolor/48x48/apps
                fi
	done
        install ${WORKDIR}/terminal.png ${D}${datadir}/icons/hicolor/48x48/apps
        install ${WORKDIR}/pattern.png ${D}${datadir}/icons/hicolor/48x48/apps

        mkdir -p ${D}/usr/bin/weston-clients
        cp ${S}/clients/weston-calibrator ${D}/usr/bin/weston-clients/
        cp ${S}/clients/weston-clickdot ${D}/usr/bin/weston-clients/
        cp ${S}/clients/weston-cliptest ${D}/usr/bin/weston-clients/
        cp ${S}/clients/weston-dnd ${D}/usr/bin/weston-clients/
        cp ${S}/clients/weston-editor ${D}/usr/bin/weston-clients/
        cp ${S}/clients/weston-eventdemo ${D}/usr/bin/weston-clients/
        cp ${S}/clients/weston-flower ${D}/usr/bin/weston-clients/
        cp ${S}/clients/weston-fullscreen ${D}/usr/bin/weston-clients/
        cp ${S}/clients/weston-image ${D}/usr/bin/weston-clients/
        cp ${S}/clients/weston-keyboard ${D}/usr/bin/weston-clients/
        cp ${S}/clients/weston-multi-resource ${D}/usr/bin/weston-clients/
        cp ${S}/clients/weston-resizor ${D}/usr/bin/weston-clients/
        cp ${S}/clients/weston-simple-egl ${D}/usr/bin/weston-clients/
        cp ${S}/clients/weston-simple-im ${D}/usr/bin/weston-clients/
        cp ${S}/clients/weston-simple-shm ${D}/usr/bin/weston-clients/
        cp ${S}/clients/weston-simple-touch ${D}/usr/bin/weston-clients/
        cp ${S}/clients/weston-smoke ${D}/usr/bin/weston-clients/
        cp ${S}/clients/weston-subsurfaces ${D}/usr/bin/weston-clients/
        cp ${S}/clients/weston-desktop-shell ${D}/usr/bin/weston-clients/
        cp ${S}/clients/weston-info ${D}/usr/bin/weston-clients/
        cp ${S}/clients/weston-screenshooter ${D}/usr/bin/weston-clients/
        cp ${S}/clients/weston-tablet-shell ${D}/usr/bin/weston-clients/
        cp ${S}/clients/weston-terminal ${D}/usr/bin/weston-clients/
        cp ${S}/clients/weston-transformed ${D}/usr/bin/weston-clients/

        mkdir -p ${D}/usr/libexec
        cp ${S}/clients/weston-desktop-shell ${D}/usr/libexec/
        cp ${S}/clients/weston-screenshooter ${D}/usr/libexec/
        cp ${S}/clients/weston-tablet-shell ${D}/usr/libexec/

	mkdir -p ${D}/home/root
        mkdir -p ${D}/home/root/.config
        cp ${S}/weston.ini ${D}/home/root/.config/
        cp ${WORKDIR}/profile ${D}/home/root/.profile

}

do_configure() {
	aclocal -I ${STAGING_DIR_TARGET}/usr/share/aclocal
        ./autogen.sh --prefix=/usr --host=arm-linux --with-libtool-sysroot=${STAGING_DIR_TARGET} --enable-weston-launch
}

PACKAGES += "${PN}-examples"

FILES_${PN} = "${bindir}/weston* ${bindir}/wcap-decode ${libexecdir} ${datadir} ${libdir}/weston/* /home/root/.profile /home/root/.config/* /usr/libexec/weston-desktop-shell /usr/libexec/weston-screenshooter /usr/libexec/weston-tablet-shell" 
FILES_${PN}-examples = "${bindir}/*"

FILES_${PN}-dbg += "${bindir}/weston-clients/.debug"

RDEPENDS_${PN} += "xkeyboard-config"
RRECOMMENDS_${PN} = "liberation-fonts"

USERADD_PACKAGES = "${PN}"
GROUPADD_PARAM_${PN} = "--system weston-launch"

INSANE_SKIP_weston += "dev-deps"

FILESEXTRAPATHS_prepend := "${THISDIR}:"
