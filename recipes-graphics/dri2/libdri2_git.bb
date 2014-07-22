HOMEPAGE = "https://git.ti.com/glsdk/libdri2"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=827da9afab1f727f2a66574629e0f39c"

PR = "r2"

DEPENDS = "dri2proto-glsdk"

inherit autotools pkgconfig

SRC_URI = "git://git.ti.com/glsdk/libdri2.git;protocol=git"

S = "${WORKDIR}/git"

SRCREV = "bdde948604f3bc46cc3153eb376b95fa82e29585"

EXTRA_OECONF += "--enable-test "
