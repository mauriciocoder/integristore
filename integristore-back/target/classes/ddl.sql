--
-- Database: `integristore`
--

-- --------------------------------------------------------

--
-- Table structure for table `checkout`
--

CREATE TABLE `checkout` (
  `checkout_id` bigint(20) NOT NULL,
  `cart_price` double NOT NULL,
  `card_number` bigint(20) NOT NULL,
  `exp_date_month` int(11) NOT NULL,
  `exp_date_year` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL
);

--
-- Table structure for table `checkout_product`
--

CREATE TABLE `checkout_product` (
  `checkout_id` bigint(20) NOT NULL,
  `product_id` bigint(20) NOT NULL
);

--
-- Table structure for table `product`
--
CREATE TABLE `product` (
  `product_id` bigint(20) NOT NULL,
  `can_sell` tinyint(1) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double NOT NULL
);


INSERT INTO `product` (`product_id`, `can_sell`, `description`, `image`, `name`, `price`) VALUES
(1, 1, 'OontZ Angle 3 ULTRA : Portable Bluetooth Speaker - Exceptional Bass and Stereo Sound Plays Loud with 14 Watts, Play to 2 Together with Dual Stereo, 100ft Wireless Range, Splashproof, Just Released', 'https://images-na.ssl-images-amazon.com/images/I/71iB2i3WDxL._SL1500_.jpg', 'Portable Bluetooth Speaker', 34.99),
(2, 1, 'Wireless headset Dylan V4.1 Bluetooth Foldable Hi-Fi Stereo Over-Ear Headphone with 3.5mm Audio Jack MIC for Smart Phones & Tablets - Black', 'https://images-na.ssl-images-amazon.com/images/I/61muqXlcPwL._SL1500_.jpg', 'Wireless headset Dylan V4.1', 17.52),
(3, 1, 'Mooncolour Mens Novelty Color Block Hoodies Cozy Sport Outwear', 'https://images-na.ssl-images-amazon.com/images/I/61dUtjfsixL._UX342_.jpg', 'Color Block Hoodies Cozy Sport Outwear', 99.99);

--
-- Indexes for table `checkout`
--
ALTER TABLE `checkout`
  ADD PRIMARY KEY (`checkout_id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`product_id`);

--
-- AUTO_INCREMENT for table `checkout`
--
ALTER TABLE `checkout`
  MODIFY `checkout_id` bigint(20) NOT NULL AUTO_INCREMENT;