#!/bin/sh

set -e
OS=`uname`
if [[ "Linux" = $OS ]]; then
    alias techo='echo -e'
else
    alias techo='echo'
fi

#check is an sudoer(root)
function check_sudoer()
{
    if [ "$(id -u)" != "0" ]; then
        techo "Please use sudo users to run this shell."
        exit 0
    fi
}

#init JAVA_BIN
function init_java_bin()
{
    JAVA_BIN=`which java`
    if [ ! -e ${JAVA_BIN} ]; then
        techo "Error:java is invalid"
        exit 0
    fi
}

#init environment
function init()
{
    check_sudoer                                          #check sudo user or root
    init_java_bin

	SERVER_NAME="heyx-service"
	HEAP_MEMORY=2048m

    BIN_HOME=`dirname "$0"`                               #get bin home
    BIN_HOME=`cd "$BIN_HOME";pwd`                         #change path to bin home
    APP_HOME=`dirname "$BIN_HOME"`                        #get app home

	LOG_HOME=/data/logs/java/heyx
	mkdir -p $LOG_HOME
    ALL_LOG_FILE=${LOG_HOME}/heyx-service-all.log
    ERROR_LOG_FILE=${LOG_HOME}/heyx-service-error.log
    GC_LOG_FILE=${APP_HOME}/gc.log
	PID_FILE=${BIN_HOME}/pid;
    if [ ! -f $PID_FILE ];then
		touch ${PID_FILE};
	else
		PID=$(cat ${PID_FILE});
        if [ ! -z "$PID" ];then
			PID_EXIST=`ps aux | grep $PID | grep -v 'grep'|wc -l`;
			if [ "$PID_EXIST" -gt 0 ];then
				techo "service is running,no need to start again!...";
				exit 1;
			fi
        fi
	fi

	JAVA_OPTS=" -Xms${HEAP_MEMORY}
	-Xmx${HEAP_MEMORY}
	-Djava.ext.dirs=$APP_HOME/WEB-INF/lib/:$JAVA_HOME/jre/lib:$JAVA_HOME/jre/lib/ext
	-XX:+DisableExplicitGC
	-verbose:gc
	-XX:+PrintGCTimeStamps
	-XX:+PrintHeapAtGC
	-XX:+PrintGCDetails
	-Xloggc:${GC_LOG_FILE}
	-XX:+HeapDumpOnOutOfMemoryError
	-XX:HeapDumpPath=${APP_HOME}
	-XX:+UseCompressedOops"
}

init
techo "Starting Server ${SERVER_NAME}... "
techo "with jvm args ${JAVA_OPTS}"
techo "Server Home: ${APP_HOME}"
nohup java $JAVA_OPTS -jar ${APP_HOME}/lib/democ-service.jar >/dev/null 2>&1 &
techo "$!" > ${PID_FILE};
techo "Start Server ${SERVER_NAME} With PID:$(cat $PID_FILE)"
#techo
#techo "SHOW  ALL  LOG: tail -100f $ALL_LOG_FILE"
#techo "SHOW ERROR LOG: tail -100f $ERROR_LOG_FILE"
