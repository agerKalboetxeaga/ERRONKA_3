# -*- coding: utf-8 -*-
# from odoo import http


# class Partidak(http.Controller):
#     @http.route('/partidak/partidak/', auth='public')
#     def index(self, **kw):
#         return "Hello, world"

#     @http.route('/partidak/partidak/objects/', auth='public')
#     def list(self, **kw):
#         return http.request.render('partidak.listing', {
#             'root': '/partidak/partidak',
#             'objects': http.request.env['partidak.partidak'].search([]),
#         })

#     @http.route('/partidak/partidak/objects/<model("partidak.partidak"):obj>/', auth='public')
#     def object(self, obj, **kw):
#         return http.request.render('partidak.object', {
#             'object': obj
#         })
