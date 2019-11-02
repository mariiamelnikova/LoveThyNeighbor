/*
 * Add your services here
 */

export async function callService(path, method, headerObj, bodyObj) {
    var baseURL = "http://localhost:8080/";
    var fullURL = baseURL + path;

    var result = {};
    if (method === "GET") {
        try {
            result = await fetch(fullURL, {
                method: "GET",
                headers: headerObj
            });
        } catch (error) {
            result = {};
            result.ok = false;
            result.url = path;
            result.statusText = "Service error:  " + path;
        }
    } else {
        try {
            result = await fetch(fullURL, {
                method: method,
                headers: headerObj,
                body: JSON.stringify(bodyObj)
            });
        } catch (error) {
            result = {};
            result.ok = false;
            result.url = path;
            result.statusText = "Service error:  " + path;
        }
    }

    if (result.ok !== true) {
        var emsg = result.statusText;
        if (result.status === 404) {
            emsg = "Service not found:  " + result.url;
        }
        const errObj = {
            error: true,
            code: result.status,
            message: emsg,
            url: result.url
        };
        return errObj;
    } else {
        const data = await result.json();
        return data;
    }
}

export async function getUsers(userId) {
    var headerObj = {
        "Content-Type": "application/json"
    };
    var bodyObj = {};
    var response = await callService(
        "users/" + userId.toString(),
        "GET",
        headerObj,
        bodyObj
    );

    return response;
}

export async function getBlockInfo(blockNumber) {
    var headerObj = {
        "Content-Type": "application/json"
    };
    var bodyObj = {};
    var response = await callService(
        "/users/block/" + blockNumber.toString(),
        "GET",
        headerObj,
        bodyObj
    );

    return response;
}

export default getBlockInfo;