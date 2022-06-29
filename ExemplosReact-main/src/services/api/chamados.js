import axios from '../../config/axios'; 

export const addChamado = chamado =>
{
    return axios
    .post(`/chamados/`, chamado)
    .then(response => {
        return response;
    })
    .catch(error => {
        return null;
    });
}

export const updateChamado = chamado =>
{
    return axios
    .put(`chamados/`, chamado)
    .then(response => {
        return response;
    })
    .catch(error => {
        return null;
    });
}

export const getAll = () =>
{
    return axios
    .get(`/chamados/`)
    .then(response => {
        return response;
    })
    .catch(error => {
        return null;
    });
}

export const getById = id =>
{
    return axios
    .get(`/chamados/${id}`)
    .then(response => {
        return response;
    })
    .catch(error => {
        return null;
    });
}

