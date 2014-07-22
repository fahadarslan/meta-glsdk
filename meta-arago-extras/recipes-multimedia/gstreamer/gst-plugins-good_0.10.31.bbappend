SRC_URI = "git://git.ti.com/glsdk/gst-plugins-good0-10.git;protocol=git"
SRCREV = "733289614c50ff4e490d5a37ec4af3a540d1dfb9"

LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=a6f89e2100d9b6cdffcea4f398e37343"

PR = "r0"

COMPATIBLE_MACHINE = "omap-a15"

S = "${WORKDIR}/git"

do_configure_prepend() {
	git submodule init && git submodule update
	autopoint -f
}

FILES_${PN} += "\
                ${libdir}/*.so \
                ${libdir}/gstreamer-0.10/*"

SRC_URI += "file://0001-v4l2-fix-build-with-recent-kernels-the-v4l2_buffer-i.patch"
