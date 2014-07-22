require recipes-graphics/xorg-xserver/xserver-xorg.inc

PR = "r0"

S = "${WORKDIR}/git"

FILESEXTRAPATHS_prepend := "${THISDIR}:"

SRC_URI = "git://git.ti.com/glsdk/xserver.git \
           file://xorg.conf.d \
           "

SRCREV = "1680ed87f202cedafa8e80239a825c2694172de2"

LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://COPYING;md5=74df27b6254cc88d2799b5f4f5949c00"

PROVIDES = "virtual/xserver"

DEPENDS += "xf86driproto dri2proto-glsdk"

EXTRA_OECONF = "--enable-dri2 --enable-record --disable-glx --disable-dri"

do_install_append() {
        mkdir -p ${D}/${datadir}/X11/
        cp -r ${WORKDIR}/xorg.conf.d ${D}/${datadir}/X11/
        cp ${S}/hw/xfree86/dri2/dri2.h ${D}/usr/include/xorg/
}

PACKAGECONFIG[glx] = " --enable-dri2 ,\
                      --enable-dri2,\
                      xf86driproto dri2proto-glsdk"

FILESEXTRAPATHS_prepend := "${THISDIR}:"
