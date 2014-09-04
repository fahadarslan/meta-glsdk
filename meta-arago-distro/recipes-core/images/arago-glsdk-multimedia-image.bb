# GLSDK multimedia image
# gives you an image with basic multimedia test application

require arago-image.inc

COMPATIBLE_MACHINE = "(?!omap-a15)"

# The size of the uncompressed ramdisk is 32MB
ROOTFS_SIZE = "32768"

IMAGE_INSTALL += "\
    packagegroup-arago-base \
    packagegroup-arago-console \
    packagegroup-arago-glsdk-console \
    packagegroup-arago-glsdk-multimedia \
    packagegroup-arago-tisdk-connectivity \
    packagegroup-arago-test \
    packagegroup-arago-tisdk-matrix \
    "
export IMAGE_BASENAME = "arago-glsdk-multimedia-image"
