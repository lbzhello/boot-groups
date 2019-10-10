export function get(url) {
    return fetch(url, {
        method: 'GET',
        credentials: 'include'
    }).then(res => {
        console.log('GET' + " " + res.url + " " + res.status)
        console.log("content-type: " + res.headers.get("content-type"))
        return res.text()
    })
}

export function post(url, data) {
    return fetch(url, {
        method: 'POST',
        body: JSON.stringify(data),
        credentials: 'include',
        headers: new Headers({
            "Content-Type": "application/json"
        })
    }).then(res => {
        console.log('POST' + " " + res.url + " " + res.status)
        console.log("content-type: " + res.headers.get("content-type"))
        return res.text()
    }).then(res => console.log(res))
}