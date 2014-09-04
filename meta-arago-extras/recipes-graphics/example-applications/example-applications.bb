SUMMARY = "GLSDK example applications"
HOMEPAGE = "http://git.ti.com"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=10a9abb9c5bb19edd83a8cf66eef7148"

DEPENDS = "gstreamer libdrm ti-ipc"

COMPATIBLE_MACHINE = "omap-a15"

inherit autotools pkgconfig

SRC_URI = "git://git.ti.com/glsdk/example-applications.git;protocol=git"
SRCREV = "a21dd98d5686a6c4563f89966cb459158085dd1b"

S = "${WORKDIR}/git"
