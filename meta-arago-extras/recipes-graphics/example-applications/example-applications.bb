SUMMARY = "GLSDK example applications"
HOMEPAGE = "http://git.ti.com"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=10a9abb9c5bb19edd83a8cf66eef7148"

DEPENDS = "gstreamer libdrm ti-ipc"

COMPATIBLE_MACHINE = "omap-a15"

inherit autotools pkgconfig

SRC_URI = "git://git.ti.com/glsdk/example-applications.git;protocol=git"
SRCREV = "95aa56d6757770165b8817845f664db9440e4a4a"

S = "${WORKDIR}/git"
