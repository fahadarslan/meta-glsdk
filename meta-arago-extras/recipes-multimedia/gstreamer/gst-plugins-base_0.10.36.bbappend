SRC_URI = "git://git.ti.com/glsdk/gst-plugins-base0-10.git;protocol=git \
           "
SRCREV = "3427e885daa749275e07339d3633b83c717aa419"

LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=0636e73ff0215e8d672dc4c32c317bb3"

PR = "r0"

COMPATIBLE_MACHINE = "omap-a15"

S = "${WORKDIR}/git"

do_configure_prepend() {
	git submodule init && git submodule update
	autopoint -f
}

EXTRA_OECONF +="--disable-ivorbis "

FILES_${PN} += "\
                ${libdir}/*.so \
                ${libdir}/gstreamer-0.10/*"


FILESEXTRAPATHS_prepend := "${THISDIR}:"
