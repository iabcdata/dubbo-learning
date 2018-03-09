#!/bin/sh

set -e
OS=`uname`
if [[ "Linux" = $OS ]]; then
    alias techo='echo -e'
else
    alias techo='echo'
fi

#init environment
function init()
{
    check_sudoer                                          #check sudo user or root

    BIN_HOME=`dirname "$0"`                               #get bin home
    BIN_HOME=`cd "$BIN_HOME";pwd`                         #change path to bin home
    APP_HOME=`dirname "$BIN_HOME"`                        #get app home

	PID_FILE=${BIN_HOME}/pid;
	if [ ! -f $PID_FILE ];then
		echo " pid file($PID_FILE) can not be found , please check service is running !...";
		exit 1;
    else
		PID=`cat ${PID_FILE}`;
        PID_EXIST=$(ps aux | grep $PID | grep -v 'grep'|wc -l);
        if [ "$PID_EXIST" -eq 0 ];then
            techo "service was stoped, no need to stop again!...";
            exit 1;
        fi
	fi
}

#check is an sudoer(root)
function check_sudoer()
{
    if [ "$(id -u)" != "0" ]; then
        techo "Please use sudo users to run this shell."
        exit 0
    fi
}

init
#Stop Server
PID=`cat ${PID_FILE}`;
PID_EXIST=$(ps aux | grep ${PID} | grep -v 'grep');
if [ ! -z "$PID_EXIST" ];then
	techo "Stopping the demob-service . pid:${PID}";
    cat $PID_FILE | xargs kill -9 > /dev/null 2>&1;
    #techo > $PID_FILE
    rm -f $PID_FILE
fi
techo "Stoped!"


#ps axfww | grep demob-service | grep -v grep | awk '{print $1}' | xargs kill -9
#ps axww | grep demob-service | grep -v grep | awk '{print $1}' | xargs kill -9

