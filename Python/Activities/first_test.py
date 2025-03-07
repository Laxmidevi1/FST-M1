import pytest
import math

def test_sqrt():
   num = 25
   assert math.sqrt(num) == 5

def test_square():
   num = 7
   assert num*num == 40
   
def tese_equality():
   assert 10 == 11