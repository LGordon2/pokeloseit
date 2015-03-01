from bs4 import BeautifulSoup
import urllib

f = urllib.urlopen('http://pokemondb.net/pokedex/stats/height-weight')
soup = BeautifulSoup(f.read())
soup.pretty_print()