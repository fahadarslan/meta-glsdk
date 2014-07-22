FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://0001-Remove-extra-DRI2SwapBuffers.patch \
            file://0002-video-support-for-dri2.patch \
           "
