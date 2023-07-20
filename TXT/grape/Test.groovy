import groovyx.net.http.RESTClient
import static groovyx.net.http.ContentType.JSON
import groovy.json.JsonSlurper
import groovy.json.JsonOutput

url = "http://restapi3.apiary.io"

@Grab (group = 'org.codehaus.groovy.modules.http-builder', module = 'http-builder', version = '0.5.0')
def client = new RESTClient(url)

@Grapes([
   @Grab(group='commons-primitives', module='commons-primitives', version='1.0'),
   @Grab(group='org.springframework', module='spring-orm', version='5.2.8.RELEASE')])
def emptyHeaders = [:]
emptyHeaders."Accept" = 'application/json'
emptyHeaders."Prefer" = 'test'