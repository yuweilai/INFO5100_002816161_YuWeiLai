from PIL import Image
import numpy as np
import tensorflow as tf

def preprocess_image(image_path):
    # Load the image using PIL
    img = Image.open(image_path).convert('L')  # Convert to grayscale
    img = img.resize((28, 28))  # Resize to 28x28 pixels
    img = np.array(img)  # Convert to numpy array
    img = img.reshape(1, 28, 28, 1)  # Reshape for model input
    img = img / 255.0  # Normalize pixel values
    return img

def recognize_digit(image_path):
    # Load the trained TensorFlow model
    model = tf.keras.models.load_model('trained_model.h5')
    
    # Preprocess the image
    img = preprocess_image(image_path)
    
    # Perform prediction
    prediction = model.predict(img)
    
    # Get the predicted digit
    recognized_digit = np.argmax(prediction)
    
    return recognized_digit


###########################################################################
# Example usage
image_path = 'drawn_digit.png'
# from matplotlib import pyplot as plt
# np_img = plt.imread(image_path)
# print(np_img.shape)


# img = preprocess_image(image_path)
# print(img.shape)
# print(img)
recognized_digit = recognize_digit(image_path)
print("Recognized digit:", recognized_digit)

###########################################################################
# examine mnist dataset
# from tensorflow.keras.datasets import mnist
# (x_train, y_train), (x_test, y_test) = mnist.load_data()
# print(x_train[0]/255.0)
# print(x_train[0].shape)
# training image: 0. - 1., background value = 0
# raw image is 28x28; model is trained on Bx28x28x1 (B=batch size, 1 is number of image/input channels)
