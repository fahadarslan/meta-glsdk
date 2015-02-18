DESCRIPTION = "Provides a filesystem with multimedia components and a test application"
LICENSE = "MIT"
PR = "r1"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

ARAGO_GLSDK_MULTIMEDIA = "\
    libdce \
    libav \
    libavformat \
    omapdrmtest \
    ti-ipc \
    omapconf \
    ltp-ddt \
    iperf \
    bc \
    nfs-utils \
    nfs-utils-client \
    gstreamer1.0 \
    gstreamer1.0-plugins-base \
    gstreamer1.0-plugins-good \
    gstreamer1.0-plugins-bad \
    gstreamer1.0-plugins-ducati \
    gstreamer1.0-plugins-vpe \
    "

ARAGO_GLSDK_MULTIMEDIA_append_dra7xx-evm = "\
   ipumm-fw \
   dspdce-fw  \
   vis \
    "

ARAGO_GLSDK_WAYLAND = "\
    libpam \
    wayland \
    weston \
    weston-examples \
    "

ARAGO_GLSDK_APPS = "\
    glsdk-example-apps \
    cpuloadgen \
    img-pvr-sdk \
    visionsdk \
    visionsdk-staticdev \
    infoadas \
    "

ARAGO_GLSDK_DEV = "\
    libgbm-dev \
    libdce-dev \
    libav-dev \
    ti-ipc-dev \
    libavcodec-dev \
    libavutil-dev \
    libavformat-dev \
    libavformat-staticdev \
    libxkbcommon \ 
    libxkbcommon-dev \ 
    mtdev-dev \
    wayland-dev \
    fontconfig-dev \
    libturbojpeg \
    "

RDEPENDS_${PN} = "\
    ${ARAGO_GLSDK_MULTIMEDIA} \
    ${ARAGO_GLSDK_WAYLAND} \
    ${ARAGO_GLSDK_APPS} \
    ${ARAGO_GLSDK_DEV} \
    "

RRECOMMENDS_${PN} = "\
    kernel-modules \
    "
