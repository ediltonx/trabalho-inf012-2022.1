import React, { useState, useEffect } from 'react';
import { getAll } from "../../../services/api/chamados";
import CircularProgress from '@material-ui/core/CircularProgress';
import { makeStyles } from "@material-ui/core/styles";
import { DataGrid } from '@mui/x-data-grid';
import Card from '@material-ui/core/Card';
import './sytle.css';

export default function Chamados() {

  const columns = [
    { field: "id", headerName: "ID", width: 100 },
    { field: "assunto", headerName: "Assunto", width: 300, editable: false },
    { field: "status", headerName: "Status", width: 300, editable: false },
    { field: "complemento", headerName: "Complemento", width: 300 },
  ];

  const classes = useStyles();
  const [loading, setLoading] = useState(false);
  const [chamados, setChamados] = useState([]);

  useEffect(() => {
    async function getItems() {

      try {
        var response = await getAll();

        if (response.status === 200) {
          setChamados(response.data.content);
          setLoading(false)
        }
      } catch (error) {
        console.log("Ocorreu um erro", "", "error");
      }
    }

    getItems();
  }, []);

  const montarDados = () => {
    if (typeof chamados.length === "undefined")
      return;

    return chamados.map(chamado => {
      return {
        id: chamado.id,
        assunto: chamado.assunto,
        status: chamado.status,
        complemento: chamado.complemento,
      }
    });
  }

  if (loading) {
    return (
      <div class="loading">
        <CircularProgress />
      </div>
    );
  } else {
    return (
      <div>
      <div className={classes.fundo}>
        <h1>Chamados</h1>
        <Card className={classes.root} variant="outlined" style={{ height: 650, width: '100%' }} >
          <div style={{ height: 450, marginLeft: "10px", marginRight: "10px", paddingTop: "50px" }}>
            <DataGrid
              columns={columns}
              rows={montarDados()}
              pageSize={5}
              rowsPerPageOptions={[5]}
            />
          </div>
        </Card>
      </div>
      </div>
    );
  }
}

const useStyles = makeStyles((theme) => ({
  root: {
    marginLeft: "auto",
    marginRight: "auto",
    maxWidth: '50%',
    marginTop: 25,
  },
  tooltip: {
    backgroundColor: theme.palette.common.white,
    color: 'rgba(0, 0, 0, 0.87)',
    boxShadow: theme.shadows[1],
    fontSize: 11,
  },
  fundo:
  {
    background: '#f7f6f4',
    height: '100vh',
  },
  titulo:
  {
    marginLeft: "220px",
    marginRight: "auto",
    marginTop: 100,
    display: 'flex'
  }
}));