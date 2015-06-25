PR = "r3"

SRC_URI = "git://git.linaro.org/tools/pm-qa.git;protocol=git;branch=${BRANCH} \
           file://0001-THERMAL-Remove-relative-path-to-Switches.sh.patch \
           "

do_install () {
    install -d ${D}${bindir}
    install -d ${D}${bindir}/linaro-pm-qa-include

    # Install the compiled binaries
    for x in `find . -name "*.c"`
    do
        util=`echo ${x} | sed s/.c$//`
        util_basename=`basename ${util}`
        install -m 0755 ${util} ${D}${bindir}/${util_basename}
    done

    # Install the helper scripts in the include directory
    for script in `find ./include -name "*.sh" | grep include`
    do
        # Remove hardcoded relative paths
        sed -i -e 's#..\/utils\/##' ${script}
        sed -i -e 's#\.\.\/##' ${script}

        script_basename=`basename ${script}`
        install -m 0755 $script ${D}${bindir}/linaro-pm-qa-include/${script_basename}
    done

    # Install the shell scripts NOT in the include directory since those
    # will be installed elsewhere
    for script in `find . -name "*.sh" | grep -v include`
    do
        # if the script includes any helper scripts from the include
        # directory then change the include path to the absolute path
        # and to reflect the install location of the helper scripts.
        sed -i -e "s#source ../include#source ${bindir}/linaro-pm-qa-include#g" ${script}
        # Remove hardcoded relative paths
        sed -i -e 's#..\/utils\/##' ${script}

        script_basename=`basename ${script}`
        install -m 0755 $script ${D}${bindir}/${script_basename}
    done
}

FILESEXTRAPATHS_prepend := "${THISDIR}:"
