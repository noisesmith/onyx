## Plugins

Plugins serve as an abstract to compose mechanisms for getting data in and out of Onyx. See the README.md of the project for a list of official Onyx plugins, or keep reading to roll your own.

<!-- START doctoc generated TOC please keep comment here to allow auto update -->
<!-- DON'T EDIT THIS SECTION, INSTEAD RE-RUN doctoc TO UPDATE -->
**Table of Contents**  *generated with [DocToc](http://doctoc.herokuapp.com/)*

- [Interfaces](#interfaces)
- [Templates](#templates)

<!-- END doctoc generated TOC please keep comment here to allow auto update -->

### Interfaces

In order to implement a plugin, a number of multimethods need to be extended from the [Pipeline Extensions API](../../src/onyx/peer/pipeline_extensions.clj). Reader plugins will implement `read-batch`, `ack-message`, `retry-message`, `pending?`, and `drained?`. Writer plugins will implement `write-batch` and `seal-resource`. See the docstrings for instructions on implementation.

### Templates

To help move past the boilerplate of creating new plugins, use Leiningen with [`onyx-plugin`](https://github.com/onyx-platform/onyx-plugin) to generate a template.
