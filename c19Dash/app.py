import flask
from flask_caching import Cache
import dash
import dash_bootstrap_components as dbc

# initialize app
server = flask.Flask(__name__)
app = dash.Dash(
    __name__,
    server=server,
    external_stylesheets=[
        dbc.themes.SLATE,  # Bootswatch theme
        "https://use.fontawesome.com/releases/v5.9.0/css/all.css", ],
    meta_tags=[{
        "name": "description",
        "content": "Live coronavirus news, statistics, and visualizations tracking the number of cases and death toll "
                   "due to COVID-19, with up-to-date testing center information by US states and counties. Also "
                   "provides current SARS-COV-2 vaccine progress and treatment research across different countries. "
                   "Sign up for SMS updates."}, {"name": "viewport", "content": "width=device-width, initial-scale=1.0"
                                                 }, ], )

