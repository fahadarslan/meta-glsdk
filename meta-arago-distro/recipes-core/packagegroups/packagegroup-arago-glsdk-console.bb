DESCRIPTION = "Extended task to get more basic and console apps in GLSDK"
LICENSE = "MIT"
PR = "r1"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

ARAGO_GLSDK_CONSOLE = "\
    libdrm \
    libdrm-kms \
    libgbm \
    cairo \
    pixman \
    expat \
    omap5-sgx-ddk-um-linux \
    omap5-sgx-ddk-um-linux-dev \
    omapdrm-pvr \
    libdrm-tests \   
    "

ARAGO_GLSDK_CONSOLE_append_omap5-evm = "\
    abefw \
    "

ARAGO_GLSDK_CONSOLE_DEMOS = "\
    kmscube \
    "

ARAGO_GLSDK_CONSOLE_MULTIMEDIA = "\
    gstreamer \
    gst-plugins-base \
    gst-plugins-good \
    "

RDEPENDS_${PN} = "\
    ${ARAGO_GLSDK_CONSOLE} \
    ${ARAGO_GLSDK_CONSOLE_DEMOS} \
    "

RRECOMMENDS_${PN} = "\
    kernel-modules \
    "
