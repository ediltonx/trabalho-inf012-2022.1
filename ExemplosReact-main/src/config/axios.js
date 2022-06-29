import axios from 'axios';

const baseURL = 'http://127.0.0.1:8080/';

const api = axios.create({
    baseURL: baseURL
});

export default api;