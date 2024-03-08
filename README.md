# bookstore

Dig sec from Tardland.

This application was generated using JHipster 7.8.1, you can find documentation and help at [https://www.jhipster.tech](https://www.jhipster.tech).

## Project Structure

Node is required for generation and recommended for development. `package.json` is always generated for a better development experience with prettier, commit hooks, scripts and so on.

In the project root, JHipster generates configuration files for tools like git, prettier, eslint, husk, and others that are well known and you can find references in the web.

`/src/*` structure follows default Java structure.

- `npmw` - wrapper to use locally installed npm.
  JHipster installs Node and npm locally using the build tool by default. This wrapper makes sure npm is installed locally and uses it avoiding some differences different versions can cause. By using `./npmw` instead of the traditional `npm` you can configure a Node-less environment to develop or test your application.
- `/src/main/docker` - Docker configurations for the application and services that the application depends on

## Development

Before you can build this project, you must install and configure the following dependencies on your machine:

1. [Node.js][]: We use Node to run a development web server and build the project.
   Depending on your system, you can install Node either from source or as a pre-packaged bundle.

After installing Node, you should be able to run the following command to install development tools.
You will only need to run this command when dependencies change in [package.json](package.json).

```
npm install
```

We use npm scripts and [Webpack][] as our build system.

Run the following commands in two separate terminals to create a blissful development experience where your browser
auto-refreshes when files change on your hard drive.

```
./mvnw
npm start
```

Npm is also used to manage CSS and JavaScript dependencies used in this application. You can upgrade dependencies by
specifying a newer version in [package.json](package.json). You can also run `npm update` and `npm install` to manage dependencies.
Add the `help` flag on any command to see how you can use it. For example, `npm help update`.

The `npm run` command will list all of the scripts available to run for this project.

## Testing

To launch your application's tests, run:

```
./mvnw verify
```

### Client tests

Unit tests are run by [Jest][]. They're located in [src/test/javascript/](src/test/javascript/) and can be run with:

```
npm test
```

For more information, refer to the [Running tests page][].

## Using Docker to simplify development 

You can use Docker to improve your JHipster development experience. A number of docker-compose configuration are available in the [src/main/docker](src/main/docker) folder to launch required third party services.

For example, to start a mysql database in a docker container, run:

Search docker command which builds the app docker:
```
'java:docker': './mvnw -DskipTests -Pprod jib:dockerBuild
```
Then composeUp the app.yml file which raises mysql and app.


For more information refer to [Using Docker and Docker-Compose][].

### The Task
   
1) Add an API in the backend that will return only cheap books (Price is less/equal than 20).
   Keep in mind that although now you have only a few books, one day you will have
   millions of them.
2) In this task we use an API provided by the New York Times. The API call will return the
   author's book list.
   Given an author, the API should return the list of the author’s books (Note: The API
   provides the reviews, you’ll have to extract the relevant values out of it) using a 3rd party
   API of https://developer.nytimes.com/docs/books-product/1/overview - “Books API”.
   Please design your code in a way which allows replacing the 3rd party API with other
   providers in an easy way (e.g tomorrow your teammate will have to add another API).
   Commit and push everything to GitHub.
   Create your own API keys in https://developer.nytimes.com
3) Check everthing works by using the swaggers generated through the app.   

Notes:

● Aim to spend no more than approximately 3 hours on this task!!!!

[jhipster homepage and latest documentation]: https://www.jhipster.tech
[jhipster 7.8.1 archive]: https://www.jhipster.tech
[using jhipster in development]: https://www.jhipster.tech/development/
[using docker and docker-compose]: https://www.jhipster.tech/docker-compose
[using jhipster in production]: https://www.jhipster.tech/production/
[running tests page]: https://www.jhipster.tech/running-tests/
[code quality page]: https://www.jhipster.tech/code-quality/
[setting up continuous integration]: https://www.jhipster.tech/setting-up-ci/
[node.js]: https://nodejs.org/
[npm]: https://www.npmjs.com/
[webpack]: https://webpack.github.io/
[browsersync]: https://www.browsersync.io/
[jest]: https://facebook.github.io/jest/
[leaflet]: https://leafletjs.com/
[definitelytyped]: https://definitelytyped.org/
