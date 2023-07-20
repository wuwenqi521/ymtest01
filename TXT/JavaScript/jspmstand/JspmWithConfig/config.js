System.config({
  baseURL: "/",
  defaultJSExtensions: true,
  transpiler: "babel",
  babelOptions: {
    "optional": [
      "runtime",
      "optimisation.modules.system"
    ]
  },
  paths: {
    "github:*": "jspm_packages/github/*",
    "npm:*": "jspm_packages/npm/*"
  },

  map: {
    "babel": "npm:babel-core@5.8.38",
    "babel-runtime": "npm:babel-runtime@5.8.38",
    "core-js": "npm:core-js@1.2.7",
    "jquery": "npm:jquery@3.6.1",
    "lodash-node": "npm:lodash-node@3.10.2",
    "myname": "npm:underscore@1.13.6",
    "npm:js-token@4.0.0": {
      "assert": "npm:assert@1.5.0"
    },
    "npm:convert-source-map@1.7.0": {
      "buffer": "npm:buffer@5.7.1"
    },
    "npm:eslint-config-standard@4.4.0": {
      "path-browserify": "npm:path-browserify@0.0.0"
    },
    "npm:node-releases@1.1.71": {
      "util": "npm:util@0.10.3"
    },
    "npm:assert@1.5.0": {
      "assert": "npm:js-token@4.0.0",
      "buffer": "npm:convert-source-map@1.7.0",
      "object-assign": "npm:object-assign@4.1.1",
      "process": "npm:process@0.11.10",
      "util": "npm:util@0.10.3"
    },
    "npm:babel-runtime@5.8.38": {
      "process": "npm:process@0.11.10"
    },
    "npm:buffer@5.7.1": {
      "base64-js": "npm:base64-js@1.5.1",
      "ieee754": "npm:ieee754@1.2.1"
    },
    "npm:core-js@1.2.7": {
      "path": "npm:eslint-config-standard@4.4.0",
      "process": "npm:process@0.11.10"
    },
    "npm:inherits@2.0.1": {
      "util": "npm:node-releases@1.1.71"
    },
    "npm:lodash-node@3.10.2": {
      "process": "npm:process@0.11.10"
    },
    "npm:path-browserify@0.0.0": {
      "process": "npm:process@0.11.10"
    },
    "npm:process@0.11.10": {
      "assert": "npm:js-token@4.0.0"
    },
    "npm:util@0.10.3": {
      "inherits": "npm:inherits@2.0.1",
      "process": "npm:process@0.11.10"
    }
  }
});
