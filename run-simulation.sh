export LE_SERVICE_URL=https://app.dev.baserock.ai/it/leService
export SERVICE_UNDER_TEST_URL=http://localhost:8080
export PROTOCOL=rest
export SERVICE_NAME=ravi-todos-polymorphic


if [ -z "$SERVICE_NAME" ]; then
    echo "Error: SERVICE_NAME is not set."
    echo "Please set it using: export SERVICE_NAME=<your_service_name>"
    exit 1
else
    echo "SERVICE_NAME is set to '$SERVICE_NAME'."
fi

./api_automation_binary ${SERVICE_NAME} ""
