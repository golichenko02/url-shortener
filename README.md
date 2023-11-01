# URL shortener
Simple url shortener with redis cache

## Prerequisite: Docker Installation

Before you can use this project, make sure you have Docker installed on your local machine. Docker is a containerization platform that allows you to easily package, distribute, and run applications in isolated containers.

You can download and install Docker by following the instructions on the official Docker website: [Get Docker](https://www.docker.com/get-started)

To verify your Docker installation, you can run the following command in your terminal:

```sh
docker --version
```


# Running the Application

To get the application up and running on your local environment, follow these steps:

1. **Clone the Repository:** Start by cloning this repository to your local environment using Git. You can do this with the following command:

    ```sh
    git clone <repository_url>
    ```

   Replace `<repository_url>` with the actual URL of the repository.


2. **Start the Application:** Navigate to the root directory of the application and run the following Docker Compose command to start the application in the background:

    ```sh
    docker-compose up -d
    ```

   This command will launch the necessary containers and services for the application. The `-d` flag runs the containers in detached mode, allowing you to continue using your terminal.


## Testing the API with an HTTP Client

   To test the API endpoints, you can use an HTTP client collection provided in the `http-client-collection/url-shortener.http` file. This collection includes pre-configured requests to interact with the API.

   If you're using a tool like [Postman](https://www.postman.com/) or [VS Code REST Client](https://marketplace.visualstudio.com/items?itemName=humao.rest-client), follow these steps:

   - Open your HTTP client.
   - Import the `url-shortener.http` file into your client. This file contains a set of requests you can use to test the API.

   Once you've imported the collection, you can send requests to the API endpoints and observe the responses.

That's it! Your application is running, and you can now use the provided HTTP client collection to interact with the API.