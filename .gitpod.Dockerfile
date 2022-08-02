FROM gitpod/workspace-full

USER gitpod

RUN bash -c ". /home/gitpod/.sdkman/bin/sdkman-init.sh && \
    sdk install JavaSE-1.8 && \
    sdk default JavaSE-1.8"