DESCRIPTION = "GStreamer elements to use the multimedia accelerators available on some TI parts"
LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=fbc093901857fcd118f065f900982c24"


# Include file for common build settings for TI GStreamer plugins
DEPENDS += "gstreamer1.0 gstreamer1.0-plugins-base gstreamer1.0-plugins-bad libdrm libdce"

inherit autotools pkgconfig gettext

INC_PR = "r0"

PR = "${INC_PR}.11"
SRCREV = "59fb5be20da72a2f5fb4f25587be668532a90c3b"

SRC_URI = "git://git.ti.com/glsdk/gst-plugin-ducati.git;protocol=git \
          "

SRC_URI_append = " \
        "

S = "${WORKDIR}/git"

do_configure() {
	cd ${S}
	chmod +x autogen.sh
	./autogen.sh --host=arm-linux --with-libtool-sysroot=${STAGING_DIR_TARGET} --prefix=/usr
}

EXTRA_OECONF += "--enable-maintainer-mode"
EXTRA_OEMAKE += "'ERROR_CFLAGS=-Wno-deprecated-declarations'"

FILES_${PN} += "${libdir}/gstreamer-1.0/*.so"
 
