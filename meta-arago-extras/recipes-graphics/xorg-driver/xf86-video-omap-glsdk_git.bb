require recipes-graphics/xorg-xserver/xserver-xorg.inc

SRC_URI = "git://git.ti.com/glsdk/xf86-video-omap.git"

SRCREV = "c51d1a32a580684760117e5f36748a4e2950260c"

LIC_FILES_CHKSUM = "file://COPYING;md5=10ce5de3b111315ea652a5f74ec0c602"

DEPENDS += "virtual/libx11 drm xf86driproto udev xorg-xserver-glsdk"

PR = "r0"

S = "${WORKDIR}/git"

LICENSE = "MIT"

DEPENDS += "virtual/libx11 drm xf86driproto udev"

PROVIDES = "xf86-video-omap"

do_install_prepend() {
	mkdir -p ${D}/var/log
}

FILES_${PN} += "/usr/lib/xorg/modules/drivers/*"

FILESEXTRAPATHS_prepend := "${THISDIR}:"
