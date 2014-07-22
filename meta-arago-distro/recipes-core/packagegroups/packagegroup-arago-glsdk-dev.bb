DESCRIPTION = "Extended task to get development tools in GLSDK"
LICENSE = "MIT"
PR = "r2"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

ARAGO_GLSDK_DEV = "\
    gdb \
    openssh \
    gst-plugins-ugly \
    git \
    nfs-utils \
    inetutils \
    iperf \
    bc \
    gcc \
    binutils \
    autoconf \
    nfs-utils \
    "

ARAGO_GLSDK_DBG = "\
    libdri2-dbg \
    "

RDEPENDS_${PN} = "\
    ${ARAGO_GLSDK_DEV} \
    ${ARAGO_GLSDK_DBG} \
    "

RRECOMMENDS_${PN} = "\
    kernel-modules \
    "
