# Jenkins container

This project sets up a docker container for Jenkins, together with the plugins and seed jobs that are used on our Jenkins production environment.

## How to use

Our Makefile contains the commands required to manage the container. Look in this file for all available commands.

To start everything:

`make run`

Jenkins will be running on port 8080 of the localhost of your machine.

### Login credentials

You don't need to login to see jobs, but to do anything useful you'll want to log in.

A user is created as part of the container setup:

Username: admin
Password: admin

## Plugin set

The plugins to be installed are all defined in `plugins.txt`. All recommended Jenkins 2 plugins are installed.
