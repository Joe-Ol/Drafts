'''

Environment = States, Action and Rewards

'''

import numpy as np

# Define environment

environment_rows = 11
environment_cols = 11

q_values = np.zeros((environment_rows, environment_cols, 4))

actions = ['up', 'right', 'down', 'left']

rewards = np.full((environment_cols, environment_rows, 4), -100.)
rewards[0, 5] = 100     # End goal

# Define Pathways
paths = {}
paths[1] = [i for i in range(1, 10)]
paths[2] = [1, 7, 9]
paths[3] = [i for i in range(1, 8)]
paths[3].append(9)
paths[4] = [3, 7]
paths[5] = [i for i in range(11)]
paths[6] = [5]
paths[7] = [i for i in range(1, 10)]
paths[8] = [3, 7]
paths[9] = [i for i in range(11)]

for row_index in range(1, 10):
    for col_index in paths[row_index]:
        rewards[row_index, col_index] = 1.

for row in rewards:
    print(row)


def is_terminal_state(current_row_index, current_column_index):
    # basically check if the reward at this position is -1 i.e. a white box
    if rewards[current_row_index, current_column_index] == -1:
        return False
    else:
        return True


# Function to choose some random but non terminal starting point
def get_starting_point():
    # get a random row & column
    current_row_index = np.random.randint(environment_rows)
    current_column_index = np.random.randint(environment_rows)
    
    # continue choosing random points until non terminal state is found i.e. until a white square is chosen
    while is_terminal_state(current_column_index, current_column_index):
        current_row_index = np.random.randint(environment_rows)
        current_column_index = np.random.randint(environment_rows)
    
    return current_row_index, current_column_index


# define epsilon greedy algorithm
def get_next_action(current_row_index, current_column_index):
    # TODO
