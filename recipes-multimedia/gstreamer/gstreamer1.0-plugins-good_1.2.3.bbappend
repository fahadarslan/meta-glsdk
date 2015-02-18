FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = " \
        file://0001-Adds-GST_V4L2_IO_DMABUF-mode-support-in-capture.patch"

PR = "r2"
