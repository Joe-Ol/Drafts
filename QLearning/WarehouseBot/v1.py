# Libraries
import numpy as np

# Define environment
environment_rows = 11
environment_columns = 11


# Create a 3D numpy array to hold the current Q-values for each state and action pair: Q(s, a) 
# The value of each (state, action) pair is initialized to 0.
q_values = np.zeros((environment_rows, environment_columns, 4))
actions = ['up', 'right', 'down', 'left']

rewards = np.full((environment_rows, environment_columns), -100.)
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
        rewards[row_index, col_index] = -1.

# for row in rewards:
    # print(row)


def is_terminal_state(current_row_index, current_column_index):
    # basically check if the reward at this position is -1 i.e. a white box
    if rewards[current_row_index, current_column_index] == -1.:
        return False
    else:
        return True


# Function to choose some random but non terminal starting point
def get_starting_location():
    # get a random row & column
    current_row_index = np.random.randint(environment_rows)
    current_column_index = np.random.randint(environment_columns)

    # continue choosing random points until non terminal state is found i.e. until a white square is chosen
    while is_terminal_state(current_column_index, current_column_index):
        current_row_index = np.random.randint(environment_rows)
        current_column_index = np.random.randint(environment_columns)
    return current_row_index, current_column_index


# define epsilon greedy algorithm
def get_next_action(current_row_index, current_column_index, epsilon):
    """
    if a randomly chosen value between 0 aad 1 is less than the epsilon,
    then choose the most promising value from the Q-table for this state
    """
    if np.random.random() < epsilon:
        return np.argmax(q_values[current_row_index, current_column_index])
    else:   # choose a random action
        return np.random.randint(4)


# define a function that will get the next location based on the chosen action
def get_next_location(current_row_index, current_column_index, action_index):
    new_row_index = current_row_index
    new_column_index = current_column_index
    if actions[action_index] == 'up' and current_row_index > 0:
        new_row_index -= 1
    elif actions[action_index] == 'right' and current_column_index < environment_columns - 1:
        new_column_index += 1
    elif actions[action_index] == 'down' and current_row_index < environment_rows - 1:
        new_row_index += 1
    elif actions[action_index] == 'left' and current_column_index > 0:
        new_column_index -= 1
    return new_row_index, new_column_index


# define function to ge the shortest path
def get_shortest_path(start_row_index, start_column_index):
    # Return immediately if this is an invalid starting point
    if is_terminal_state(start_row_index, start_column_index):
        return []
    else:
        current_row_index, current_column_index = start_row_index, start_column_index
        shortest_path = []
        shortest_path.append([current_row_index, current_column_index])

        while not is_terminal_state(current_row_index, current_column_index):
            action_index = get_next_action(current_row_index, current_column_index, 1.)
            current_row_index, current_column_index = get_next_location(current_row_index, current_column_index, action_index)
            shortest_path.append([current_row_index, current_column_index])
        return shortest_path


# Training
epsilon = 0.9   # the percentage of time we should take the best action
discount_factor = 0.9   # the discount factor for future rewards
learning_rate = 0.9

# run through 100 training episodes
for episode in range(1000):
    # get starting location for this episode
    row_index, col_index = get_starting_location()

    # continue moving till termianl state is reached
    while not is_terminal_state(row_index, col_index):
        # choose which location to take:
        action_index = get_next_action(row_index, col_index, epsilon)

        # perform chosen action
        old_row_index, old_col_index = row_index, col_index
        row_index, col_index = get_next_location(row_index, col_index, action_index)

        # receive the reward for moving to the new state, and calculate the temporal difference
        reward = rewards[row_index, col_index]
        old_q_value = q_values[old_row_index, old_col_index, action_index]
        temporal_difference = reward + (discount_factor * np.max(q_values[row_index, col_index])) - old_q_value

        # update the q-value for the previous state and action pair
        new_q_value = old_q_value + (learning_rate * temporal_difference)
        q_values[old_row_index, old_col_index, action_index] = new_q_value

# print("Training Complete")

# print(get_shortest_path(3, 9))
# print(get_shortest_path(3, 9))

path = get_shortest_path(9, 5)
path.reverse()
print(path)

