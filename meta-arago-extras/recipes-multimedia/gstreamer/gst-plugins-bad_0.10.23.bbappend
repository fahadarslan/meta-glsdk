SRC_URI = "git://git.ti.com/glsdk/gst-plugins-bad0-10.git;protocol=git"

SRCREV = "a9510bef52331fee9a23a5c955dbf76ac210056a"

LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=0636e73ff0215e8d672dc4c32c317bb3"

DEPENDS += "omap5-sgx-ddk-um-linux libdce libdri2 libdrm wayland "

PR = "r0"

COMPATIBLE_MACHINE = "omap-a15"

S = "${WORKDIR}/git"

EXTRA_OECONF += " --disable-pvr --enable-dri2"

do_configure_prepend() {
	git submodule init && git submodule update
	autopoint -f
}

do_install_append() {
        mkdir -p  ${D}/${libdir}/gstreamer-0.10/
        cp ${S}/sys/dri2/.libs/libgstdri2.so ${D}/${libdir}/gstreamer-0.10/
}
FILES_${PN} += "\
                ${libdir}/*.so \
                ${libdir}/gstreamer-0.10/*"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
