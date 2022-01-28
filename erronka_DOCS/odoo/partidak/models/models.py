# -*- coding: utf-8 -*-

#Model class for our Module of Partidak

from odoo import models, fields, api

class partida(models.Model):
	_name = "partidak.partida"
	_description = "Partida baten ezaugarriak ezartzen digun modeloa."
	_order = 'puntuazioa'
	
	puntuazioa = fields.Integer(string='Puntuazioa')
	kills = fields.Integer(string='Kills')
	time = fields.Char(string='Run Time')
	date = fields.Datetime(string='Fecha de la azaña')
	res_partner_id = fields.Many2one(comodel_name='hr.employee', string='Employee') #Relation with hr_employee
	function = fields.Char(string='Function',related='res_partner_id.department_id.name', store=True, readonly=False) #getting department name 
	
	#Possible future feature...
	#manquismo= fields.Char(string='Eres malo pero...', compute='imBetter')



