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
    openbox \
    openbox-theme-clearlooks \
    nfs-utils \
    nfs-utils-client \
    "

ARAGO_GLSDK_MULTIMEDIA_append_dra7xx-evm = "\
   ipumm-fw \
   dspdce-fw  \
   vis \
    "

ARAGO_GLSDK_GSTREAMER = "\
    gstreamer \
    gst-plugins-base \
    gst-plugins-good \
    gst-plugins-bad \
    gst-plugins-ducati \
    "    

ARAGO_GLSDK_GSTREAMER_append_dra7xx-evm = "\
    gst-plugins-vpe \
    "

ARAGO_GLSDK_WAYLAND = "\
    libpam \
    wayland \
    weston \
    xkbcommon \
    "

ARAGO_GLSDK_BLTSVILLE = "\
    bltsville \
    bltsville-dev \
    bvtest \
    "

ARAGO_GLSDK_APPS = "\
    example-applications \
    cpuloadgen \
    "

ARAGO_GLSDK_XSERVER = "\
    xorg-xserver-glsdk \
    xorg-xserver-glsdk-dev \
    xf86-video-omap-glsdk \
    xf86-input-evdev \
    xf86-video-fbdev \
    dri2proto-glsdk-dev \
    libdri2 \
    libxft \
    xinit \
    xterm \
    xclock \
    xorg-xserver-glsdk-extension-dbe \
    xorg-xserver-glsdk-extension-extmod \
    xorg-xserver-glsdk-extension-dri2 \
    xorg-xserver-glsdk-module-exa \
    xorg-xserver-glsdk-extension-record \
    xrandr \
    libxrandr \
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
    libxcursor-dev \ 
    libxkbcommon \ 
    libxkbcommon-dev \ 
    mtdev-dev \
    wayland-dev \
    fontconfig-dev \
    libturbojpeg \
    libdri2-dev \
    "

RDEPENDS_${PN} = "\
    ${ARAGO_GLSDK_MULTIMEDIA} \
    ${ARAGO_GLSDK_GSTREAMER} \
    ${ARAGO_GLSDK_WAYLAND} \
    ${ARAGO_GLSDK_BLTSVILLE} \
    ${ARAGO_GLSDK_APPS} \
    ${ARAGO_GLSDK_XSERVER} \
    ${ARAGO_GLSDK_DEV} \
    "

RRECOMMENDS_${PN} = "\
    kernel-modules \
    "
