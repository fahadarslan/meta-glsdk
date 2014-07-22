inherit autotools pkgconfig gettext

SRC_URI = "git://git.ti.com/glsdk/gst-plugin-ducati.git;protocol=git"

SRCREV = "61e1538ef8ce206d01b36ddced211ffabfcc9377"

LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=fbc093901857fcd118f065f900982c24"

PR = "r0"

S = "${WORKDIR}/git"

DEPENDS += "gstreamer gst-plugins-base gst-plugins-bad libdrm libdce"

do_configure() {
	cd ${S}
	chmod +x autogen.sh
	./autogen.sh --host=arm-linux --with-libtool-sysroot=${STAGING_DIR_TARGET} --prefix=/usr
}

EXTRA_OECONF += "--enable-maintainer-mode"
EXTRA_OEMAKE += "'ERROR_CFLAGS=-Wno-deprecated-declarations'"

FILES_${PN} += "/usr/lib/gstreamer-0.10/*"

FILESEXTRAPATHS_prepend:="${THISDIR}:"
