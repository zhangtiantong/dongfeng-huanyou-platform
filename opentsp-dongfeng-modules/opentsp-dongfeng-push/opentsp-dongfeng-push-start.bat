set module_name=opentsp-dongfeng-push
title %module_name%
@echo off
echo Begin  %module_name% Running ...
 java -jar -Xmx512m -Xms512m -XX:+UseConcMarkSweepGC   %module_name%-1.0-SNAPSHOT-boot.jar
@pause