FROM gitpod/workspace-full

USER gitpod

RUN bash -c ". /home/gitpod/.sdkman/bin/sdkman-init.sh \
             && sdk install java 1.8.0-oracle \
             && sdk default java 1.8.0-oracle"
