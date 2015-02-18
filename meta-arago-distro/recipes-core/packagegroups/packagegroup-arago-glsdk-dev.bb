DESCRIPTION = "Extended task to get development tools in GLSDK"
LICENSE = "MIT"
PR = "r2"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

ARAGO_GLSDK_DEV = "\
    gdb \
    dropbear \
    git \
    inetutils \
    "

RDEPENDS_${PN} = "\
    ${ARAGO_GLSDK_DEV} \
    "

RRECOMMENDS_${PN} = "\
    kernel-modules \
    "
