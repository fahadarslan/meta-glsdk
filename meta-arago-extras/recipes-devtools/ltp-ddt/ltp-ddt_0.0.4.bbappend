BRANCH = "v3.12"
SRCREV = "c7146cbea93282247d77dae93259a0af043bfba6"


SRC_URI = "git://arago-project.org/git/projects/test-automation/ltp-ddt.git;protocol=git;branch=${BRANCH}" 


PR = "r10"

FILESEXTRAPATHS_prepend := "${THISDIR}:"
