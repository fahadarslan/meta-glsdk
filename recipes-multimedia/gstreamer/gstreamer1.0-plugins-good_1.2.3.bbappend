PR = "r1"

SRC_URI_append = " \
        file://0002-gstv4l2src-Optimize-delay-in-capture.patch"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
