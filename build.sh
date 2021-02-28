#!/bin/bash
cd customers && . build.sh && cd ..
cd eureka && . build.sh && cd ..
cd gateway && . build.sh && cd ..
cd products && . build.sh && cd ..
cd sellers && . build.sh && cd ..
cd stores && . build.sh && cd ..
cd suppliers && . build.sh && cd ..