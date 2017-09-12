// vars/buildPlugin.groovy
def call(body) {
    // evaluate the body block, and collect configuration into the object
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    // now build, based on the configuration provided
    node {
        echo "${config.fullurl}"
        echo "user name is ${config.uid}"
	echo "group name is : ${config.groupid}"
    }
}
