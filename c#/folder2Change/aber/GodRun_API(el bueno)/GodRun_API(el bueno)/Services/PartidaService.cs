﻿using GodRun_API_el_bueno_.Models;

using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Threading.Tasks;

namespace GodRun_API_el_bueno_.Services
{
    public class PartidaService : IPartidaService
    {
        private Uri url = new Uri("http://192.168.65.6:8080/");

        public async Task<IList<Partida>> GetHoF()
        {
            List<Partida> partida_List = new List<Partida>();
            Uri rutaHoF = new Uri(url, "hof");

            using (var httpClient = new HttpClient())
            {
                using (var response = await httpClient.GetAsync(rutaHoF))//ensi rutapartida_ind
                {
                    string apiResponse = await response.Content.ReadAsStringAsync();
                    partida_List = JsonConvert.DeserializeObject<List<Partida>>(apiResponse);
                }
            }
            return partida_List;
        }

        public async Task<IList<Partida>> GetHoS()
        {
            List<Partida> partida_List = new List<Partida>();
            Uri rutaHoS = new Uri(url, "hos");

            using (var httpClient = new HttpClient())
            {
                using (var response = await httpClient.GetAsync(rutaHoS))//ensi rutapartida_ind
                {
                    string apiResponse = await response.Content.ReadAsStringAsync();
                    partida_List = JsonConvert.DeserializeObject<List<Partida>>(apiResponse);
                }
            }
            return partida_List;
        }

        public async Task<IList<Partida>> GetIzena(string izena)
        {
            List<Partida> partida_List = new List<Partida>();
            Uri rutapartida_izena = new Uri(url, "partida?name=" + izena);
            using (var httpClient = new HttpClient())
            {
                using (var response = await httpClient.GetAsync(rutapartida_izena))//ensi rutapartida_ind
                {
                    string apiResponse = await response.Content.ReadAsStringAsync();
                    partida_List = JsonConvert.DeserializeObject<List<Partida>>(apiResponse);
                }
            }
            return partida_List;
        }

        public async Task<IList<Partida>> GetMota(int id)
        {
            List<Partida> partida_List = new List<Partida>();
            Uri rutapartida_ind = new Uri(url, "partidak/"); //ruta donde miraremos por string se

            using (var httpClient = new HttpClient())
            {
                using (var response = await httpClient.GetAsync(rutapartida_ind))//ensi rutapartida_ind
                {
                    string apiResponse = await response.Content.ReadAsStringAsync();
                    partida_List = JsonConvert.DeserializeObject<List<Partida>>(apiResponse);
                }
            }
            return partida_List;
        }

        public async Task<IList<Partida>> GetPartidas()
        {
            List<Partida> partida_List = new List<Partida>();
            Uri rutapartida_ind = new Uri(url, "partidak/"); //ruta donde miraremos por string se

            using (var httpClient = new HttpClient())
            {
                using (var response = await httpClient.GetAsync(rutapartida_ind))//ensi rutapartida_ind
                {
                    string apiResponse = await response.Content.ReadAsStringAsync();
                    partida_List = JsonConvert.DeserializeObject<List<Partida>>(apiResponse);
                }
            }
            return partida_List;
        }
    }
}