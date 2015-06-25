PR = "r6"

PACKAGECONFIG = "faad wayland"

SRCREV = "22f32534ce54035c33c8e788b46dc257621b472c"

SRC_URI = "git://git.ti.com/glsdk/gstreamer1-0-plugins-bad.git;protocol=git \
          "

S = "${WORKDIR}/git"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
