DESCRIPTION = "GStreamer elements to use the multimedia accelerators available on some TI parts"
LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=fbc093901857fcd118f065f900982c24"

require gst-plugins-ti.inc

PR = "${INC_PR}.1"
SRCREV = "cc0acccadc5a606a39dffd87520b6d87d62f6c22"

SRC_URI = "git://git.ti.com/glsdk/gst-plugin-ducati.git;protocol=git"
