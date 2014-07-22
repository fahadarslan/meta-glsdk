# GLSDK console image
# gives you an image with basic media libraries

require arago-image.inc

COMPATIBLE_MACHINE = "(?!omap-a15)"

# The size of the uncompressed ramdisk is 32MB
ROOTFS_SIZE = "32768"

IMAGE_INSTALL += "\
    packagegroup-arago-base \
    packagegroup-arago-console \
    packagegroup-arago-glsdk-console \
    "
export IMAGE_BASENAME = "arago-glsdk-console-image"
